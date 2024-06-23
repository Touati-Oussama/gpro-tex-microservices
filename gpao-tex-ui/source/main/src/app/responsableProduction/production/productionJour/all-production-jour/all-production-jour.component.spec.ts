import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllProductionJourComponent } from './all-production-jour.component';

describe('AllProductionJourComponent', () => {
  let component: AllProductionJourComponent;
  let fixture: ComponentFixture<AllProductionJourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllProductionJourComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllProductionJourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
