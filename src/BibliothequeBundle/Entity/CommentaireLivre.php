<?php

namespace BibliothequeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * CommentaireLivre
 *
 * @ORM\Table(name="commentaire_livre")
 * @ORM\Entity(repositoryClass="BibliothequeBundle\Repository\CommentaireLivreRepository")
 */
class CommentaireLivre
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="Commentaire", type="text", nullable=false)
     */
    private $commentaire;



    /**
     * @ORM\ManyToOne(targetEntity="AppBundle\Entity\User")
     * @ORM\JoinColumn(name="locataire", referencedColumnName="id")
     */
    private $Locataire;

    /**
     * @ORM\ManyToOne(targetEntity="Livre")
     * @ORM\JoinColumn(name="livre", referencedColumnName="id")
     */
    private $Livre;


    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set commentaire
     *
     * @param string $commentaire
     *
     * @return CommentaireLivre
     */
    public function setCommentaire($commentaire)
    {
        $this->commentaire = $commentaire;

        return $this;
    }

    /**
     * Get commentaire
     *
     * @return string
     */
    public function getCommentaire()
    {
        return $this->commentaire;
    }

    /**
     * Set locataire
     *
     * @param \AppBundle\Entity\User $locataire
     *
     * @return CommentaireLivre
     */
    public function setLocataire(\AppBundle\Entity\User $locataire = null)
    {
        $this->Locataire = $locataire;

        return $this;
    }

    /**
     * Get locataire
     *
     * @return \AppBundle\Entity\User
     */
    public function getLocataire()
    {
        return $this->Locataire;
    }

    /**
     * Set livre
     *
     * @param \BibliothequeBundle\Entity\Livre $livre
     *
     * @return CommentaireLivre
     */
    public function setLivre(\BibliothequeBundle\Entity\Livre $livre = null)
    {
        $this->Livre = $livre;

        return $this;
    }

    /**
     * Get livre
     *
     * @return \BibliothequeBundle\Entity\Livre
     */
    public function getLivre()
    {
        return $this->Livre;
    }
}
