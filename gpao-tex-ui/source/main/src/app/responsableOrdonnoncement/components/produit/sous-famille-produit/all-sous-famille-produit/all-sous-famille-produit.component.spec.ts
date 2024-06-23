import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllSousFamilleProduitComponent } from './all-sous-famille-produit.component';

describe('AllSousFamilleProduitComponent', () => {
  let component: AllSousFamilleProduitComponent;
  let fixture: ComponentFixture<AllSousFamilleProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllSousFamilleProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllSousFamilleProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
