export interface IUser {
    user_id:number,
    first_name:string,
    last_name:string,
    email:string,
    username:string,
    password:string,
    phone:number
}

export type AppState = {
    user:IUser,
}