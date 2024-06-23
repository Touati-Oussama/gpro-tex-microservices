import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllProductionHeureComponent } from './all-production-heure.component';

describe('AllProductionHeureComponent', () => {
  let component: AllProductionHeureComponent;
  let fixture: ComponentFixture<AllProductionHeureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllProductionHeureComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllProductionHeureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
