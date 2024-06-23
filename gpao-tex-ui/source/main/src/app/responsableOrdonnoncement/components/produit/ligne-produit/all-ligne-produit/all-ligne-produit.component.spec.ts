import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllLigneProduitComponent } from './all-ligne-produit.component';

describe('AllLigneProduitComponent', () => {
  let component: AllLigneProduitComponent;
  let fixture: ComponentFixture<AllLigneProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllLigneProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllLigneProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
