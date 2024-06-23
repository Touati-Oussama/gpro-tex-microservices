import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
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
import {SelectionModel} from "@angular/cdk/collections";
import {ProduitValue} from "../../../../services/product/models/produit-value";
import {fromEvent} from "rxjs";
import {MatDialog} from "@angular/material/dialog";
import {MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition} from "@angular/material/snack-bar";
import {ProduitService} from "../produitService";

@Component({
  selector: 'app-all-produit',
  standalone: true,
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
  templateUrl: './all-produit.component.html',
  styleUrl: './all-produit.component.scss'
})
export class AllProduitComponent extends UnsubscribeOnDestroyAdapter implements OnInit {
  selection = new SelectionModel<ProduitValue>(true, []);
  public productData: any;
  index?: number;
  id?: number;
  dataSource: any;
  @ViewChild(MatPaginator, {static: true}) paginator!: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort!: MatSort;
  @ViewChild('filter', {static: true}) filter!: ElementRef;
  @ViewChild(MatMenuTrigger)
  contextMenu?: MatMenuTrigger;
  contextMenuPosition = {x: '0px', y: '0px'};
  totalelemnt: any
  constructor(
    private pdService: ProduitService,
    public dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {
    super();
  }

  displayedColumns = [
    'id',
    'reference',
    'cadence',
    'code conception',
    'actions'
  ];

  ngOnInit(): void {
    this.loadProduct();
  }
  refresh() {
    this.loadProduct();
  }
  onContextMenu(event: MouseEvent, item: ProduitValue) {
    event.preventDefault();
    this.contextMenuPosition.x = event.clientX + 'px';
    this.contextMenuPosition.y = event.clientY + 'px';
    if (this.contextMenu !== undefined && this.contextMenu.menu !== null) {
      this.contextMenu.menuData = {item: item};
      this.contextMenu.menu.focusFirstItem('mouse');
      this.contextMenu.openMenu();
    }
  }
  loadProduct() {
    this.pdService.getAll()
      .subscribe(data => {
          this.productData = data;
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

  addNew() {

  }


  exportExcel() {

  }

  editCall(row: ProduitValue) {

  }

  deleteItem(row: ProduitValue) {

  }
}
