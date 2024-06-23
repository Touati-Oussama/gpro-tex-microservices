import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllPiComponent } from './all-pi.component';

describe('AllPiComponent', () => {
  let component: AllPiComponent;
  let fixture: ComponentFixture<AllPiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllPiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllPiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
