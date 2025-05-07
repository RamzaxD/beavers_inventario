interface State {
    name?: string | null;
    logged?: boolean;
  }
  interface Action {
    type: string;
    payload?: any;
  }
  export const authReducer = (state: State = {}, action: Action) => {
  
      const type = {
          Login: "[Auth] Login",
          Logout: "[Auth] Logout"
      }
  
      switch (action.type){
          case type.Login: {
              return {
                  name: action.payload.name,
                  logged: true,
              };
          }
          case type.Logout: {
              return { logged: false, name: null };
          }
          default:
              return state;
      }
  }
  