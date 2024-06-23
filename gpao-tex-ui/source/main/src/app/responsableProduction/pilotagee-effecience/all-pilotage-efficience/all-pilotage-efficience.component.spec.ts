import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllPilotageEfficienceComponent } from './all-pilotage-efficience.component';

describe('AllPilotageEfficienceComponent', () => {
  let component: AllPilotageEfficienceComponent;
  let fixture: ComponentFixture<AllPilotageEfficienceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllPilotageEfficienceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllPilotageEfficienceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
