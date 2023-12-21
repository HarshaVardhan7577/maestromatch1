import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ChatBotComponent } from '../chat-bot/chat-bot.component';

@Component({
  selector: 'app-chatboat-icon',
  templateUrl: './chatboat-icon.component.html',
  styleUrls: ['./chatboat-icon.component.css']
})
export class ChatboatIconComponent {
  showGreeting=false;
closeButton=false;
  
  display = "block";
  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
    setTimeout(() => {
      console.log("hi");
      this.showGreeting = true;
    }, 3000); // 3 seconds
  }

  openChatbox() {
    console.log("open chat bot");
    this.dialog.open(ChatBotComponent, {

    });
  }
  showCloseButton(){
    this.closeButton=true;
  }
  //to close the popUp
  dispay() {

    this.display = "none"

  }

}
