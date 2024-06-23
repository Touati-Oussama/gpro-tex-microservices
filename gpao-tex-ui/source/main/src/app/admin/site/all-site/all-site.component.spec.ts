import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllSiteComponent } from './all-site.component';

describe('AllSiteComponent', () => {
  let component: AllSiteComponent;
  let fixture: ComponentFixture<AllSiteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllSiteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllSiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
