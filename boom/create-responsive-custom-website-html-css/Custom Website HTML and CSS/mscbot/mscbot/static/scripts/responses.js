function getBotResponse(input) {
    //rock paper scissors
    if (input == "rock") {
        return "paper";
    } else if (input == "paper") {
        return "scissors";
    } else if (input == "scissors") {
        return "rock";
    }

    // Simple responses
    if (input == "hello") {
        return "Hello there!";
    } 
    
    else if (input == "goodbye") {
        return "Talk to you later!";
    }
    else if(input=="What is Navonmesh Nidhi?"){
        return "An online platform that provides mentorship to young Entrepreneurs and gives chance to get funded by the giants of market to achieve J curve in market growth.";
    }
    else if(input=="How do I sign up/register for an account?"){
        return "Simply signup with your college ID if youre a student or use your GSTIN no. if you've your platform regesterd";
    }
    else if(input=="What are the key features of Navonmesh Nidhi?"){
        return "Users get the chance to get mentored by the best(s) in the industry.";
    }
    else if(input=="Is Navonmesh Nidhi free to use?"){
        return "The platfom is absolutely free to explore, it chargers a minimal amount of 5$ a month if using features like Seach optimisation, mentorship, or External Funding.";
    }
    else if(input=="How do I reset my password?"){
        return "You can enter your college id or GSTIN no and click on forget password ,a mail will be sent to you with attached URL to proceed for further";
    }
    else if(input=="Can I use Navonmesh Nidhi on mobile devices"){
        return "Currently working upon the andoid version of it, although you can always access it in your browser, Its safe secure and easy to use.";
    }
    else if(input=="What kind of support is available if I encounter issues?"){
        return "A chat bot is always there to help you out ,even if the problem isn't resolved yo can contact to our representatives in office timings";
    }
    else if(input=="Is my data secure on Navonmesh Nidhi?"){
        return "We respect your privacy and always keep your data securd, we use blockchain to store and fetch your data, making it decentralized and way more secured than any other application";
    }
    else if(input=="Are there any community guidelines or terms of service I should be aware of?"){
        return "Always follow the guideline issued by government and keep the community friendly.";
    }
    else if(input=="How do I create a pitch on this platform?"){
        return "You can simply pitch your idea to new pitch section enter the detailed discription and you are all set to publish it.";
    }
    else if(input=="What types of projects or ideas can I pitch on this platform?"){
        return "This pitching includes every domain including , Businness consultancy, Social welfare, Open innovation and many more.";
    }
    else if(input=="Is there a specific format or template for pitching?"){
        return "We always suggest to pitch your idea in the standard pitching format for easy understanding ,good interaction and to foster intrest of investors.";
    }
    else if(input=="Can I update or edit my pitch after submitting it?"){
        return "Always try to pitch your idea in one go to reduce any confusion between you and investor.";
    }

    
    else {
        return "Try asking something else!";
    }
}