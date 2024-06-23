import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllProductionHeureDetailsComponent } from './all-production-heure-details.component';

describe('AllProductionHeureDetailsComponent', () => {
  let component: AllProductionHeureDetailsComponent;
  let fixture: ComponentFixture<AllProductionHeureDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllProductionHeureDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllProductionHeureDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
