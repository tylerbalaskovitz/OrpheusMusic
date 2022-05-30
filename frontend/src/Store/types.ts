export interface IUser {
    id: number;
    username: string;
    password: string;
}


export type AppState = {
    user: IUser, 
    
}