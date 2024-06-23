import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProductionHeureComponent } from './add-production-heure.component';

describe('AddProductionHeureComponent', () => {
  let component: AddProductionHeureComponent;
  let fixture: ComponentFixture<AddProductionHeureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddProductionHeureComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddProductionHeureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
