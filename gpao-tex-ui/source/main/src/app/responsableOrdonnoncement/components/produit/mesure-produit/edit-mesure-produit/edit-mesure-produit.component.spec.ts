import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMesureProduitComponent } from './edit-mesure-produit.component';

describe('EditMesureProduitComponent', () => {
  let component: EditMesureProduitComponent;
  let fixture: ComponentFixture<EditMesureProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditMesureProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditMesureProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
