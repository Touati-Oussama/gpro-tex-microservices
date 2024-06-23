import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProductionHeureComponent } from './edit-production-heure.component';

describe('EditProductionHeureComponent', () => {
  let component: EditProductionHeureComponent;
  let fixture: ComponentFixture<EditProductionHeureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditProductionHeureComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditProductionHeureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
