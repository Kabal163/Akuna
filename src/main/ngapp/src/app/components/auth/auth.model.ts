export class UserLoginForm {
  username: string;
  password: string;
}

export class UserRegisterForm
{
  firstName: string;
  lastName: string;
  middleName: string;
  password: string;
  confirmPassword: string;
  email: string;
  phoneNumber: string;
  city: string;
  secretQuestionId: number;
  secretAnswer: string;
}

export class SecretQuestion
{
  id: number;
  question: string;
}

export class Token
{
  token: string;
  refreshToken: string;
}
