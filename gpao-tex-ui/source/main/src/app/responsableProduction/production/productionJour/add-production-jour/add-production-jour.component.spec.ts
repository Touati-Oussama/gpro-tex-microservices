import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProductionJourComponent } from './add-production-jour.component';

describe('AddProductionJourComponent', () => {
  let component: AddProductionJourComponent;
  let fixture: ComponentFixture<AddProductionJourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddProductionJourComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddProductionJourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
