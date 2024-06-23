import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPiComponent } from './add-pi.component';

describe('AddPiComponent', () => {
  let component: AddPiComponent;
  let fixture: ComponentFixture<AddPiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddPiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddPiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
