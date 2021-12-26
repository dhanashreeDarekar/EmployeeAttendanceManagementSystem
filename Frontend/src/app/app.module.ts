
import { HttpClientModule , HttpClient } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SideNavComponent } from './side-nav/side-nav.component';
import { ProfileComponent } from './profile/profile.component';
import { OverviewComponent } from './overview/overview.component';
import { FormsModule } from '@angular/forms';
import { LeaveApplyComponent } from './leave-apply/leave-apply.component';

import { LeavesComponent } from './leaves/leaves.component';
import { AttendanceComponent } from './attendance/attendance.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { HomeComponent } from './home/home.component';
import { AddEmpComponent } from './add-emp/add-emp.component';
import { AddAttendanceComponent } from './add-attendance/add-attendance.component';
import { MyLeavesComponent } from './my-leaves/my-leaves.component';
import { EmpAttendanceComponent } from './emp-attendance/emp-attendance.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    SideNavComponent,
    ProfileComponent,
    OverviewComponent,
    LeaveApplyComponent,

    LeavesComponent,
    AttendanceComponent,
    EmpListComponent,
    HomeComponent,
    AddEmpComponent,
    AddAttendanceComponent,
    MyLeavesComponent,
    EmpAttendanceComponent,
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
