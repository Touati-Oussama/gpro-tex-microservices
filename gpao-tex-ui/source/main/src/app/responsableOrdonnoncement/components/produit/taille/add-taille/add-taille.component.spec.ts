import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTailleComponent } from './add-taille.component';

describe('AddTailleComponent', () => {
  let component: AddTailleComponent;
  let fixture: ComponentFixture<AddTailleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddTailleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddTailleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
