import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditOfComponent } from './edit-of.component';

describe('EditOfComponent', () => {
  let component: EditOfComponent;
  let fixture: ComponentFixture<EditOfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditOfComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditOfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
