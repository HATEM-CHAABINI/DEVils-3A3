<?php

namespace AppBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\Security;
use FOS\UserBundle\Event\FilterUserResponseEvent;
use FOS\UserBundle\Event\FormEvent;
use FOS\UserBundle\Event\GetResponseUserEvent;
use FOS\UserBundle\FOSUserEvents;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;
class DefaultController extends Controller
{
    /**
     * @Route("/", name="homepage")
     */
    public function indexAction(Request $request)
    {
        if ($request->isMethod("post")) {
            $email = $request->get("email");
            $password = $request->get("password");
            $userManager = $this->get('fos_user.user_manager');
          $user = $this->getDoctrine()->getRepository("AppBundle:User")->findOneBy(array("email" => $email));
          //  $user = $userManager->findUserByEmail($email);
            $encoder_service = $this->get('security.encoder_factory');
            $encoder = $encoder_service->getEncoder($user);
            if ($encoder->isPasswordValid($user->getPassword(), $password, $user->getSalt())) {
                $token = new UsernamePasswordToken($user, null, 'main', $user->getRoles());
                $this->container->get('security.token_storage')->setToken($token);
                $this->container->get('session')->set('_security_main', serialize($token));
            } else {
                var_dump('password incorect');
            }
        }
        if ($this->container->get('security.authorization_checker')->isGranted('ROLE_CLIENT')) {

            return $this->render('default/front.html.twig', [
            'base_dir' => realpath($this->getParameter('kernel.project_dir')) . DIRECTORY_SEPARATOR,
        ]);
    }else
        {
            return $this->render('default/back.html.twig', [
                'base_dir' => realpath($this->getParameter('kernel.project_dir')) . DIRECTORY_SEPARATOR,
            ]);
        }
    }


}
