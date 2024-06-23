import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllOfComponent } from './all-of.component';

describe('AllOfComponent', () => {
  let component: AllOfComponent;
  let fixture: ComponentFixture<AllOfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllOfComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllOfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
