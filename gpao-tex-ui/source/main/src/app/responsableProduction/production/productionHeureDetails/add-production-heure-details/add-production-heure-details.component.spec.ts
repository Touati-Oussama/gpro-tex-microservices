import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProductionHeureDetailsComponent } from './add-production-heure-details.component';

describe('AddProductionHeureDetailsComponent', () => {
  let component: AddProductionHeureDetailsComponent;
  let fixture: ComponentFixture<AddProductionHeureDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddProductionHeureDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddProductionHeureDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
