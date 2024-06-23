import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllMesureProduitComponent } from './all-mesure-produit.component';

describe('AllMesureProduitComponent', () => {
  let component: AllMesureProduitComponent;
  let fixture: ComponentFixture<AllMesureProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllMesureProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllMesureProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
