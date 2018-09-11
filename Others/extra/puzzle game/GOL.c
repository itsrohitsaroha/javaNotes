//GAME OF LUCK

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX 5
#define BASEDIR "d:\\gol\\"

void registerPlayer()
{
    int amt = 100;
    char name[20];
    char ch;
    char temp[100];
    FILE *fp;
    
    do
    {
        fflush(stdin);
        printf("\n Enter player name : ");
        scanf("%19s", name);
        strcpy(temp, BASEDIR);
        strcat(temp, name);
        strcat(temp, ".txt");
        //printf("\n %s", temp);
        fp = fopen(temp, "r");
        if(fp != NULL)
        {//file exists i.e. player exists
            printf("\n Sorry this username is already in use");
            printf("\n Do you want to try again (y/n) ? ");
            fflush(stdin);
            scanf("%c", &ch);
        }
        else
        {//file not found, i.e. unique player name
            fp = fopen(temp, "wb");//create
            fprintf(fp, "%d", amt);
            fclose(fp);
            printf("\nCongratulations %s, your account is created.", name);
            printf("\nRs. 100 is credit for free!!!");
            printf("\nEnjoy the game!!!");
            break;
        }
    }while(ch == 'y' || ch == 'Y');
    
}

void dropPlayer()
{
    char name[20];
    char temp[100];
    FILE *fp;
    
    fflush(stdin);
    printf("\n Enter player name : ");
    scanf("%19s", name);
    strcpy(temp, BASEDIR);
    strcat(temp, name);
    strcat(temp, ".txt");
    if(remove(temp)==0)//deletes the file from the disk
        printf("\n Player Dropped");
    else
        printf("\n Invalid Player");

}

int getAvailableAmout(char name[])
{
    char temp[100];
    FILE *fp;
    int amt = 0;
    
    strcpy(temp, BASEDIR);
    strcat(temp, name);
    strcat(temp, ".txt");
    fp = fopen(temp, "rb");
    if(fp != NULL)
    {//file exists i.e. player exists
        fscanf(fp, "%d", &amt);
        fclose(fp);
    }
    return amt;
}

void updateAccountMoney(char name[], int update)
{
    char temp[100];
    FILE *fp;
    
    strcpy(temp, BASEDIR);
    strcat(temp, name);
    strcat(temp, ".txt");
    fp = fopen(temp, "wb+");
    if(fp != NULL)
    {//file exists i.e. player exists
        fprintf(fp, "%d", update);
        fclose(fp);
        printf("\n Account Updated");
        printf("\n Balance : Rs %d", update);
    }
    else
        printf("\n Account not found");
    
}

void addMoneyToAccount(char name[], int x)
{
    int q;
    q = getAvailableAmout(name);
    q+= x;
    updateAccountMoney(name, q);
}

int play(char name[])
{
    int arr[3];
    int winValue, x;
    int playAmout, availableAmount, update;
    int i;
    
    availableAmount = getAvailableAmout(name);
    if(availableAmount == 0)
    {
        printf("\nOops, it seems that your account is empty ");
        printf("\nKindly recharge to play");
        return 0;//failure
    }
    
    printf("\nThe Game Of Luck");
    printf("\nWelcome %s ", name);
    printf("\nYou have Rs. %d in account.", availableAmount);
    printf("\nEnter play amount : ");
    scanf("%d", &playAmout);
    
    if(playAmout < 1)
    {
        printf("\n Minimum Play Amount is Re. 1");
        printf("\n Session Ends");
        return 0;
    }
    
    if(playAmout > availableAmount)
    {
        printf("\nOops, it seems you have only Rs. %d in account ", availableAmount);
        printf("\nSession Ends");
        return 0;//function ends with failure
    }
    
    //to bring variety in generated random numbers, seed the random number generator with a unique value
    srand(time(NULL));//time is unique so system gets a unique seed to generate psuedo random numbers 
    
    //fill the array with 3 random numbers
    for(i =0 ; i < 3; i++)
        arr[i] = rand() % 100;//0,1,...,99
    //select a random win value
    winValue = rand() % 3; //0,1,2
    
    //render
    printf("\n%s, Pick a number: ", name);
    for(i =0 ; i< 3; i++)
        printf("%d ", arr[i]);
    scanf("%d", &x);
    if(x == arr[winValue])
    {//wins
        printf("\n Congratulations, you win Rs. %d", playAmout*10);
        update = availableAmount + playAmout*10;
        updateAccountMoney(name, update);
    }
    else
    {//loses
        printf("\n Ohh, you lose Rs. %d", playAmout);
        update = availableAmount - playAmout;
        updateAccountMoney(name, update);
    }
    return 1;//success
}

int main()
{
    int ch, flag;
    int amt;
    char name[20];
    flag = 0;
    
    strcpy(name, ""); 
    do
    {
        printf("\n 1. New Player Registration ");
        printf("\n 2. Account Money Updation ");
        printf("\n 3. Play ");
        printf("\n 4. Close the account ");
        printf("\n 5. Exit ");
        printf("\n Enter Choice : ");
        scanf("%d", &ch);
        switch(ch)
        {
            case 1://new player
                registerPlayer();
                break;
            case 2://update mone
                printf("\n Enter username ");
                fflush(stdin);
                scanf("%19s", name);
                printf("\n Enter amount to add ");
                scanf("%u", &amt);
                addMoneyToAccount(name, amt);
                break;
            case 3://play
                if(strcmp(name, "") == 0)
                {
                    printf("\n Enter username ");
                    fflush(stdin);
                    scanf("%19s", name);
                }
                
                if(play(name)== 0)
                    flag++;
                if(flag == MAX)
                {
                    printf("\nGame Ends");
                    ch =5 ;//loop stops
                }
                break;
            case 4://close the account
                dropPlayer();
                break;
            case 5://exit
                break;
            default:
                printf("\n Wrong Choice ");
                break;
        }//switch
        
    }while(ch != 5);
    
    return 0;
}
