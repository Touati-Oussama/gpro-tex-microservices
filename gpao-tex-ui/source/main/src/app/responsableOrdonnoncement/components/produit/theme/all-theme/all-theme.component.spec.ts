import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllThemeComponent } from './all-theme.component';

describe('AllThemeComponent', () => {
  let component: AllThemeComponent;
  let fixture: ComponentFixture<AllThemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllThemeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllThemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
