import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProductionJourComponent } from './edit-production-jour.component';

describe('EditProductionJourComponent', () => {
  let component: EditProductionJourComponent;
  let fixture: ComponentFixture<EditProductionJourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditProductionJourComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditProductionJourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
