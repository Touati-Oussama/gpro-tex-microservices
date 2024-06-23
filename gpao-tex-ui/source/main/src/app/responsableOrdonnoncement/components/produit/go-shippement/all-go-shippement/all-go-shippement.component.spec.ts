import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllGoShippementComponent } from './all-go-shippement.component';

describe('AllGoShippementComponent', () => {
  let component: AllGoShippementComponent;
  let fixture: ComponentFixture<AllGoShippementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllGoShippementComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllGoShippementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
