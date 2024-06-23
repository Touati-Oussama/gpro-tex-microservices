import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllTailleComponent } from './all-taille.component';

describe('AllTailleComponent', () => {
  let component: AllTailleComponent;
  let fixture: ComponentFixture<AllTailleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllTailleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllTailleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
