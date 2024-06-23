import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPilotageEfficienceComponent } from './edit-pilotage-efficience.component';

describe('EditPilotageEfficienceComponent', () => {
  let component: EditPilotageEfficienceComponent;
  let fixture: ComponentFixture<EditPilotageEfficienceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditPilotageEfficienceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditPilotageEfficienceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
