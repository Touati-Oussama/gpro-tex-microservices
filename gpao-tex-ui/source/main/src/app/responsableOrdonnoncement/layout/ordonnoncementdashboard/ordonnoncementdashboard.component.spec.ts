import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdonnoncementdashboardComponent } from './ordonnoncementdashboard.component';

describe('OrdonnoncementdashboardComponent', () => {
  let component: OrdonnoncementdashboardComponent;
  let fixture: ComponentFixture<OrdonnoncementdashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrdonnoncementdashboardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OrdonnoncementdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
