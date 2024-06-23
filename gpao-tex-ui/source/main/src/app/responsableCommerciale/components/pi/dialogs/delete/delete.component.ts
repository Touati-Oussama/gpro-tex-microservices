import {Component, Inject} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogTitle,
  MatDialogContent,
  MatDialogActions,
  MatDialogClose,
  MatDialogRef
} from '@angular/material/dialog';
import {MatButtonModule} from "@angular/material/button";
import {PiService} from "../../piService";
export interface DialogData {
  id: number;
  matrFiscal?: string;
  reference: string;
}

@Component({
  selector: 'app-delete',
  standalone: true,
  templateUrl: './delete.component.html',
  styleUrl: './delete.component.scss',
  imports: [
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButtonModule,
    MatDialogClose,
  ],
})
export class DeleteComponent {
  constructor(
    public dialogRef: MatDialogRef<DeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    public piService: PiService
  ) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  confirmDelete(): void {
    if (confirm(`Êtes-vous sûr de vouloir supprimer cette partie prenante avec id ${this.data.id}?`)) {
      this.piService.delete(this.data.id)
        .subscribe({
          next: () => this.dialogRef.close('Deleted'),
          error: (error) => console.error('Error deleting pi:', error)
        });
    }
  }
}
