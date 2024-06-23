import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProductionHeureDetailsComponent } from './edit-production-heure-details.component';

describe('EditProductionHeureDetailsComponent', () => {
  let component: EditProductionHeureDetailsComponent;
  let fixture: ComponentFixture<EditProductionHeureDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditProductionHeureDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditProductionHeureDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
