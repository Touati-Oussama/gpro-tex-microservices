import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOfComponent } from './add-of.component';

describe('AddOfComponent', () => {
  let component: AddOfComponent;
  let fixture: ComponentFixture<AddOfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddOfComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddOfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
