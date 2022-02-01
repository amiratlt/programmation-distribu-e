import{NgModule}from'@angular/core';
import{Routes,RouterModule}from'@angular/router';
import{EmployeeListComponent}from'./employee-list/employee-list.component';
import{CreateEmployeeComponent} from'./create-employee/create-employee.component'
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import {ChercherEmployeeComponent} from './chercher-employee/chercher-employee.component'
import {DetailEmployeeComponent} from './detail-employee/detail-employee.component'
import{CreateEquipeComponent} from './create-equipe/create-equipe.component'

const routes:Routes=[
{path:'employees',component:EmployeeListComponent},
{path:'add',component: CreateEmployeeComponent},
{ path: 'update/:id', component: UpdateEmployeeComponent },
{ path: 'recherch', component: ChercherEmployeeComponent },
{ path: 'details/:id', component: DetailEmployeeComponent },
{ path: 'equipe', component: CreateEquipeComponent },
{path:'',redirectTo:'employee',pathMatch:'full'}
];
@NgModule({
imports:[RouterModule.forRoot(routes)],
exports:[RouterModule]
})
export class AppRoutingModule{}