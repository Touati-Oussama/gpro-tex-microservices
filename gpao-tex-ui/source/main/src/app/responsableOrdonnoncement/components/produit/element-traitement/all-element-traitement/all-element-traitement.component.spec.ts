import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllElementTraitementComponent } from './all-element-traitement.component';

describe('AllElementTraitementComponent', () => {
  let component: AllElementTraitementComponent;
  let fixture: ComponentFixture<AllElementTraitementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllElementTraitementComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllElementTraitementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
