import { Injectable } from '@angular/core';
import{HttpClient}from'@angular/common/http';
import{Employee}from'../employee';
import{Observable}from'rxjs';
import { Departementt } from '../departementt';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private url="http://localhost:8080/listEmployes/";

  constructor(private http:HttpClient) { }

  getEmployeesList():Observable<Employee[]>{
    return this.http.get<Employee[]>(this.url);
    }
    getEmployee(id: number):Observable<Employee>{
      return this.http.get<Employee>(this.url+id);
    }
  

    updateEmployee(id:number,employee:Employee):Observable<Employee>{
      return this.http.put<Employee>(this.url+id,employee);
      }
      deleteEmployee(id:number):Observable<string>{
      return this.http.delete<string>(this.url+id);
      }

      chercherEmployee(motcle:string):Observable<any>{
        return this.http.get<Employee[]>(this.url+"chercher/"+motcle);
      }
    
      chercherEmployeeContains(motcle:string):Observable<any>{
        return this.http.get<Employee[]>(this.url+"chercherContains/"+motcle);
      }
       //définition de la methode création de back-end
  //creation(nbD:number,nbE:number):Observable<any>{
  //  return this.http.post<Employee[]>(this.url+"listDepartements/"+nbD+"/"+nbE,{nbD,nbE});
 //}

 creation(nom:String):Observable<any>{
  return this.http.post<Departementt>(this.url+"listDepartements/"+nom,{nom});
}

 EmpParNomDept(motcle:string):Observable<any>{
   return this.http.get<Employee[]>(this.url+"empParDepNom/"+motcle);
 }

 EmpParIdDept(motcle:number):Observable<any>{
   return this.http.get<Employee[]>(this.url+"empParDepID/"+motcle);
 }

 getDepList(): Observable<Departementt[]>{
  return this.http.get<Departementt[]>(this.url+"/listDepartements");
}

getDepart(id: number):Observable<Departementt>{
  return this.http.get<Departementt>(this.url+"/listDepartements/"+id);
}


saveWithdep(emp:Employee,idDep:number):Observable<Employee>{
  return this.http.post<Employee>(this.url+"/dept/"+idDep,{idDep,emp});
  }
    
  saveEmployee(employee:Employee):Observable<Employee>{
    return this.http.post<Employee>(this.url,employee);
    }
}



