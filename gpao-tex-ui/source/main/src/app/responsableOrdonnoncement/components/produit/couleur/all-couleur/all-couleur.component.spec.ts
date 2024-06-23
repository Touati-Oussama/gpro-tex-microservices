import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllCouleurComponent } from './all-couleur.component';

describe('AllCouleurComponent', () => {
  let component: AllCouleurComponent;
  let fixture: ComponentFixture<AllCouleurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllCouleurComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllCouleurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
