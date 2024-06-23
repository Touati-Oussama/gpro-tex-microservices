import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommercialedashboardComponent } from './commercialedashboard.component';

describe('CommercialedashboardComponent', () => {
  let component: CommercialedashboardComponent;
  let fixture: ComponentFixture<CommercialedashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CommercialedashboardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CommercialedashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
