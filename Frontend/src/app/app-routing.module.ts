import { EmpListComponent } from './emp-list/emp-list.component';
import { LeavesComponent } from './leaves/leaves.component';
import { AttendanceComponent } from './attendance/attendance.component';
import { LeaveApproveComponent } from './leave-approve/leave-approve.component';
import { OverviewComponent } from './overview/overview.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LeaveApplyComponent } from './leave-apply/leave-apply.component';

const routes: Routes = [
  {path:'',component:OverviewComponent},
  {path:'login',component:LoginComponent}, 
  {path:'profile',component:ProfileComponent},
  {path:'leave-approve',component:LeaveApproveComponent},
  {path:'leave-apply',component:LeaveApplyComponent},
  {path:'attendance',component:AttendanceComponent},
  {path:'leaves',component:LeavesComponent},
  {path:'emp-list',component:EmpListComponent},

  
  {path:'**',redirectTo:''}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }


