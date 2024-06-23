import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMesureProduitComponent } from './add-mesure-produit.component';

describe('AddMesureProduitComponent', () => {
  let component: AddMesureProduitComponent;
  let fixture: ComponentFixture<AddMesureProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddMesureProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddMesureProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
