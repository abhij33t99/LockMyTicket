import { z } from "zod"

let loginFormSchema = z.object({
    username: z.string().min(2, {
        message: "Username must be at least 2 characters.",
    }).max(255, {
        message: "Username must be max 1255 characters.",
    }),
    password: z.string().min(8, {
        message: "Password must be at least 8 characters.",
    }).max(20, {
        message: "Password must be max 20 characters.",
    })
})

export default loginFormSchema;
