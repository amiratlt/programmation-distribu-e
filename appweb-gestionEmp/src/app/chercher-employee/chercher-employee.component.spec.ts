import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChercherEmployeeComponent } from './chercher-employee.component';

describe('ChercherEmployeeComponent', () => {
  let component: ChercherEmployeeComponent;
  let fixture: ComponentFixture<ChercherEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChercherEmployeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChercherEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
