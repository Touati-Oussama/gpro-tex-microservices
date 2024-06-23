import {Component, Inject} from '@angular/core';
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MAT_DIALOG_DATA, MatDialogClose, MatDialogContent, MatDialogRef} from "@angular/material/dialog";
import {
  FormsModule,
  ReactiveFormsModule,
  UntypedFormBuilder,
  UntypedFormGroup,
  Validators
} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {PiService} from "../../piService";
import {PartieInteresse} from 'app/services/pi/models';
import {MatSelectModule} from '@angular/material/select';
import {MatOptionModule} from '@angular/material/core';
import {CommonModule} from '@angular/common';

export interface DialogData {
  id: number;
  action: string;
  pi: PartieInteresse;
}

@Component({
  selector: 'app-form-dialog',
  standalone: true,
  templateUrl: './form-dialog.component.html',
  styleUrl: './form-dialog.component.scss',
  imports: [
    MatButtonModule,
    MatIconModule,
    MatDialogContent,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatDialogClose,
    MatSelectModule,
    MatOptionModule,
    CommonModule
  ],
})
export class FormDialogComponent {
  action: string;
  dialogTitle: string | undefined;
  piForm: UntypedFormGroup;
  pi: PartieInteresse;

  constructor(
    public dialogRef: MatDialogRef<FormDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    public piService: PiService,
    private fb: UntypedFormBuilder
  ) {
    // Set the defaults
    this.action = data.action;
    if (this.action === 'edit') {
      this.dialogTitle = data.pi.reference;
      this.pi = data.pi;
    } else {
      this.dialogTitle = 'Nouveau Partie Interesse';
      this.pi = {} as PartieInteresse
    }
    this.piForm = this.createContactForm();
  }
  createContactForm(): UntypedFormGroup {
    return this.fb.group({
      id: [this.pi.id, Validators.required],
      reference: [this.pi.reference, Validators.required],
      matriculeFiscal: [this.pi.matrFiscal],
      abreviation: [this.pi.abreviation],
      addresseLivraison: [this.pi.adresseLiv],
      modalitePaiement: [this.pi.modalitePaiement],
      siteId: [this.pi.siteId]
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  confirmAdd(): void {
    console.log(this.action);
    if (this.action === 'edit') {
      this.piService.updatePi(this.piForm.getRawValue())
        .subscribe(
          response => {
            console.log('Partie Interesse updated successfully!', response);
            this.dialogRef.close(1);
          },
          error => {
            console.error('Error updating Partie Interesse:', error);
            this.dialogRef.close(-1);
          }
        );
    } else {
      this.piService.createPi(this.piForm.getRawValue())
        .subscribe(
          response => {
            console.log('Partie Interesse created successfully!', response);
            this.dialogRef.close(1);
          },
          error => {
            console.error('Error adding Partie Interesse:', error);
            this.dialogRef.close(-1);
          }
        );
    }
  }
}
