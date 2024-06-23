import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditFamilleProduitComponent } from './edit-famille-produit.component';

describe('EditFamilleProduitComponent', () => {
  let component: EditFamilleProduitComponent;
  let fixture: ComponentFixture<EditFamilleProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditFamilleProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditFamilleProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
