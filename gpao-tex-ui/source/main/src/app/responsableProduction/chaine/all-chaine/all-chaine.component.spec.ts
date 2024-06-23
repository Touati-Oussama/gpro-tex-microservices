import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllChaineComponent } from './all-chaine.component';

describe('AllChaineComponent', () => {
  let component: AllChaineComponent;
  let fixture: ComponentFixture<AllChaineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllChaineComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllChaineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
