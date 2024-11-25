"use client"

import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"
import { z } from "zod"
import { Form, FormControl, FormField, FormItem, FormLabel, FormMessage } from "../ui/form"
import { Button } from "../ui/button"
import { Input } from "../ui/input"
import { cn } from "@/lib/utils"
import { LogInIcon } from "lucide-react"
import { Card, CardHeader, CardTitle, CardDescription, CardContent, CardFooter } from "../ui/card"
import loginFormSchema from "@/validation/auth-form-validation"
import { useContext } from "react"
import AuthContext from "@/security/auth-context"

const formSchema = loginFormSchema

export function AuthForm() {

    const { setUserProfile } = useContext(AuthContext)

    // 1. Define your form.
    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        defaultValues: {
            username: "",
            password: ""
        },
    })

    // 2. Define a submit handler.
    function onSubmit(values: z.infer<typeof formSchema>) {
        // Do something with the form values.
        // ✅ This will be type-safe and validated.
        console.log(values)
    }

    return (

        <Card className={cn("max-w-[380px] ml-auto mr-auto mt-16 mb-16")}>
            <CardHeader>
                <CardTitle>Login</CardTitle>
                <CardDescription>Use your registered email id and password</CardDescription>
            </CardHeader>
            <CardContent className="grid gap-8">
                <Form {...form}>
                    <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
                        <FormField
                            control={form.control}
                            name="username"
                            render={({ field }) => (
                                <FormItem>
                                    <FormLabel>Username</FormLabel>
                                    <FormControl>
                                        <Input placeholder="abc@xyz.com" {...field} />
                                    </FormControl>

                                    <FormMessage />
                                </FormItem>
                            )}
                        />
                        <FormField
                            control={form.control}
                            name="password"
                            render={({ field }) => (
                                <FormItem>
                                    <FormLabel>Password</FormLabel>
                                    <FormControl>
                                        <Input placeholder="********" {...field} type="password" />
                                    </FormControl>

                                    <FormMessage />
                                </FormItem>
                            )}
                        />
                        <Button className="w-full" type="submit"> <LogInIcon /> Login</Button>
                    </form>
                </Form>
            </CardContent>
            <CardFooter>
                <div className="ml-auto mr-auto">Don't have an account? Sign up</div>
            </CardFooter>
        </Card>

    )

}
