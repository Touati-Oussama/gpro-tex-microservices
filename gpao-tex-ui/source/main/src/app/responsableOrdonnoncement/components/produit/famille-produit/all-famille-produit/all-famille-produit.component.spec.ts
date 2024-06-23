import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllFamilleProduitComponent } from './all-famille-produit.component';

describe('AllFamilleProduitComponent', () => {
  let component: AllFamilleProduitComponent;
  let fixture: ComponentFixture<AllFamilleProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllFamilleProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllFamilleProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
