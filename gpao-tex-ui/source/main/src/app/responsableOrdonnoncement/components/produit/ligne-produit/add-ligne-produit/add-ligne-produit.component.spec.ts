import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLigneProduitComponent } from './add-ligne-produit.component';

describe('AddLigneProduitComponent', () => {
  let component: AddLigneProduitComponent;
  let fixture: ComponentFixture<AddLigneProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddLigneProduitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddLigneProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
