import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {BreadcrumbComponent} from "@shared/components/breadcrumb/breadcrumb.component";
import {MatTooltipModule} from "@angular/material/tooltip";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatTableModule} from "@angular/material/table";
import {MatSort, MatSortModule} from "@angular/material/sort";
import {CommonModule, DatePipe, NgClass} from "@angular/common";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {FeatherIconsComponent} from "@shared/components/feather-icons/feather-icons.component";
import {MatRippleModule} from "@angular/material/core";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatMenuModule, MatMenuTrigger} from "@angular/material/menu";
import {MatPaginator, MatPaginatorModule} from "@angular/material/paginator";
import {UnsubscribeOnDestroyAdapter} from "@shared";
import {MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition} from '@angular/material/snack-bar';
import {SelectionModel} from "@angular/cdk/collections";
import {PiService} from "../piService";
import {Direction} from "@angular/cdk/bidi";
import {PartieInteresseValue} from 'app/services/pi/models/partie-interesse-value';
import * as XLSX from 'xlsx';
import {FormDialogComponent} from '../dialogs/form-dialog/form-dialog.component';
import {PartieInteresse} from 'app/services/pi/models';
import {DeleteComponent} from '../dialogs/delete/delete.component';
import {fromEvent} from 'rxjs';

@Component({
  selector: 'app-all-pi',
  standalone: true,
  templateUrl: './all-pi.component.html',
  styleUrl: './all-pi.component.scss',
  imports: [
    BreadcrumbComponent,
    MatTooltipModule,
    MatButtonModule,
    MatIconModule,
    MatTableModule,
    MatSortModule,
    NgClass,
    MatCheckboxModule,
    FeatherIconsComponent,
    MatRippleModule,
    MatProgressSpinnerModule,
    MatMenuModule,
    MatPaginatorModule,
    DatePipe,
    CommonModule,
    MatPaginatorModule,
    MatSortModule
  ],
})
export class AllPiComponent extends UnsubscribeOnDestroyAdapter implements OnInit {
  selection = new SelectionModel<PartieInteresseValue>(true, []);
  public piData: any;
  private partieInteresse!: PartieInteresseValue;
  index?: number;
  id?: number;

  onContextMenu(event: MouseEvent, item: PartieInteresseValue) {
    event.preventDefault();
    this.contextMenuPosition.x = event.clientX + 'px';
    this.contextMenuPosition.y = event.clientY + 'px';
    if (this.contextMenu !== undefined && this.contextMenu.menu !== null) {
      this.contextMenu.menuData = {item: item};
      this.contextMenu.menu.focusFirstItem('mouse');
      this.contextMenu.openMenu();
    }
  }

  addNew() {
    let tempDirection: Direction;
    if (localStorage.getItem('isRtl') === 'true') {
      tempDirection = 'rtl';
    } else {
      tempDirection = 'ltr';
    }
    const dialogRef = this.dialog.open(FormDialogComponent, {
      data: {
        partieInteresse: this.partieInteresse,
        action: 'add'
      },
      direction: tempDirection,
    });
    this.subs.sink = dialogRef.afterClosed().subscribe((result) => {
      if (result === 1) {
        this.piService.dataChange.value.unshift(this.piService.getDialogData());
        this.refresh();
        this.showNotification(
          'snackbar-success',
          'Add Record Successfully...!!!',
          'bottom',
          'center'
        );
      }
    });
  }

  deleteItem(i: number, row: PartieInteresseValue) {
    this.index = i;
    this.id = row.id;
    let tempDirection: Direction;
    if (localStorage.getItem('isRtl') === 'true') {
      tempDirection = 'rtl';
    } else {
      tempDirection = 'ltr';
    }
    const dialogRef = this.dialog.open(DeleteComponent, {
      height: '270px',
      width: '300px',
      data: row,
      direction: tempDirection,
    });
    this.subs.sink = dialogRef.afterClosed().subscribe((result) => {
      if (result === 1) {
        const foundIndex = this.piService?.dataChange.value.findIndex(
          (x) => x.id === this.id
        );
        if (foundIndex !== undefined && this.piService !== undefined) {
          this.piService.dataChange.value.splice(foundIndex, 1);
          this.refresh();
          this.showNotification(
            'snackbar-success',
            'Delete Record Successfully...!!!',
            'bottom',
            'center'
          );
        }
      }
    });
  }

  editCall(row: PartieInteresseValue) {
    let tempDirection: Direction;
    if (localStorage.getItem('isRtl') === 'true') {
      tempDirection = 'rtl';
    } else {
      tempDirection = 'ltr';
    }
    const dialogRef = this.dialog.open(FormDialogComponent, {
      data: {
        pi: row,
        action: 'edit',

      },
      direction: tempDirection,
    });
    this.subs.sink = dialogRef.afterClosed().subscribe((result) => {
      if (result === 1) {
        const foundIndex = this.piService?.dataChange.value.findIndex(
          (x) => x.id === this.id
        );
        if (foundIndex !== undefined && this.piService !== undefined) {
          const updatedData = this.piService.dataChange.value.slice(0, foundIndex)
            .concat(this.piService.getDialogData())
            .concat(this.piService.dataChange.value.slice(foundIndex + 1));
          this.piService.dataChange.next(updatedData);
          this.refresh();
          this.showNotification(
            'snackbar-success',
            'Delete Record Successfully...!!!',
            'bottom',
            'center'
          );
        }
      }
    });
  }

  exportExcel() {
    if (!this.piData) {
      console.error('Data not loaded yet!');
      return;
    }
    const exportData: Partial<PartieInteresse>[] = this.piData.map((pi: PartieInteresse) => ({
      'ID': pi.id,
      'Matricule Fiscal': pi.matrFiscal,
      'Reference': pi.reference,
      'Adresse de Livraison': pi.adresseLiv,
      'Abreviation': pi.abreviation,
      'Modalite de Paiement': pi.modalitePaiement,
      'Site ID': pi.siteId,
      'creationDate': pi.creationDate,
      'modificationDate': pi.modificationDate
    }));

    const wb = XLSX.utils.book_new();
    const ws = XLSX.utils.json_to_sheet(exportData);
    XLSX.utils.book_append_sheet(wb, ws, 'Partie Interesse');
    XLSX.writeFile(wb, 'Partie_Interesse.xlsx');
  }

  refresh() {
    this.loadData();
  }

  displayedColumns = [
    'id',
    'reference',
    'abreviation',
    'adresseLiv',
    'modalitePaiement',
    'siteId',
    'actions'
  ];
  totalelemnt: any

  constructor(
    private piService: PiService,
    public dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {
    super();
  }

  dataSource: any;
  @ViewChild(MatPaginator, {static: true}) paginator!: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort!: MatSort;
  @ViewChild('filter', {static: true}) filter!: ElementRef;
  @ViewChild(MatMenuTrigger)
  contextMenu?: MatMenuTrigger;
  contextMenuPosition = {x: '0px', y: '0px'};

  ngOnInit(): void {
    this.loadData();
  }
  showNotification(
    colorName: string,
    text: string,
    placementFrom: MatSnackBarVerticalPosition,
    placementAlign: MatSnackBarHorizontalPosition
  ) {
    this.snackBar.open(text, '', {
      duration: 2000,
      verticalPosition: placementFrom,
      horizontalPosition: placementAlign,
      panelClass: colorName,
    });
  }

  loadData() {
    this.piService.getAll()
      .subscribe(data => {
          this.piData = data;
          this.totalelemnt = data.length
        },
        error => {
          console.error('Error loading Pi data:', error);
        });
    this.subs.sink = fromEvent(this.filter.nativeElement, 'keyup').subscribe(
      () => {
        if (!this.dataSource) {
          return;
        }
        this.dataSource.filter = this.filter.nativeElement.value;
      }
    );
  }
}
