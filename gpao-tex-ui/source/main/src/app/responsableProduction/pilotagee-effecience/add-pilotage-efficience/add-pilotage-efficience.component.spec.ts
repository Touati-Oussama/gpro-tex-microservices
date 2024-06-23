import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPilotageEfficienceComponent } from './add-pilotage-efficience.component';

describe('AddPilotageEfficienceComponent', () => {
  let component: AddPilotageEfficienceComponent;
  let fixture: ComponentFixture<AddPilotageEfficienceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddPilotageEfficienceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddPilotageEfficienceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
